package org.unicase.kinectmssdkeclipse;

import humandiagramgef.HumanBodyEnum;
import humandiagramgef.HumanBodyModelUtils;

import org.unicase.kinectmssdkeclipse.game.GestureListener;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SkeletalTracking {

	private final HumanBodyModelUtils humanbody;
	private GestureRecognition gestureRecognition;
	private GestureListener gestureListener;

	public void setGestureListener(GestureListener gestureListener) {
		this.gestureListener = gestureListener;
	}

	public GestureRecognition getGestureRecognition() {
		return gestureRecognition;
	}

	public SkeletalTracking() {
		this.humanbody = new HumanBodyModelUtils();
	}

	public void startSkeletonTracking() {
		this.humanbody.init();
	}

	public void parseSkeletonData(Document doc) {
		// System.out.println("---------------New Skeleton Data ------------------------");

		NodeList frameNumber = doc.getElementsByTagName("frameNumber");
		int frameNum = new Integer(frameNumber.item(0).getTextContent());
		// System.out.println("Frame Number: " + frameNum);

		NodeList timestamp = doc.getElementsByTagName("timeStamp");
		int timeStamp = new Integer(timestamp.item(0).getTextContent());
		// System.out.println("Timestamp: " + timeStamp);

		NodeList skeletonData = doc.getElementsByTagName("skeletonData");
		for (int h = 0; h < skeletonData.getLength(); h++) {
			NodeList skeleton = skeletonData.item(h).getChildNodes();
			for (int k = 0; k < skeleton.getLength(); k++) {
				Node skeletonChild = skeleton.item(k);
				if (skeletonChild.getNodeName().equals("trackingId")) {
					int trackingId = new Integer(skeletonChild.getTextContent());
					// System.out.println("trackingId: " + trackingId);
				} else if (skeletonChild.getNodeName().equals("userIndex")) {
					int userIndex = new Integer(skeletonChild.getTextContent());
					// System.out.println("userIndex: " + userIndex);
				} else if (skeletonChild.getNodeName().equals("joint")) {

					NodeList joint = skeletonChild.getChildNodes();
					// System.out.println("Joints:");
					float positionX = 0;
					float positionY = 0;
					float positionZ = 0;
					HumanBodyEnum humanPart = null;
					for (int i = 0; i < joint.getLength(); i++) {

						Node child = joint.item(i);
						if (child.getNodeName().equals("positionX")) {
							positionX = Float.parseFloat(child.getTextContent()
									.replace(',', '.'));
							// System.out.println("positionX: " + positionX);
						} else if (child.getNodeName().equals("positionY")) {
							positionY = Float.parseFloat(child.getTextContent()
									.replace(',', '.'));
							// System.out.println("positionY: " + positionY);
						} else if (child.getNodeName().equals("positionZ")) {
							positionZ = Float.parseFloat(child.getTextContent()
									.replace(',', '.'));
							// System.out.println("positionZ: " + positionZ);
						} else if (child.getNodeName().equals("jointId")) {
							String jointId = child.getTextContent();
							humanPart = getHumanPart(jointId);
							// System.out.println("jointId: " + jointId);
							if (this.gestureRecognition != null) {
								this.gestureRecognition.saveYPositions(
										humanPart, positionY);
							}

						}
					}

					this.humanbody.changeCoordinates(humanPart,
							500 + (positionX * 500), 300 - (positionY * 500),
							100 + positionZ);

					// System.out.println("Ende Joints");
				} else if (skeletonChild.getNodeName().equals("positionX")) {
					float positionX = Float.parseFloat(skeletonChild
							.getTextContent().replace(',', '.'));
					// System.out.println("positionX: " + positionX);
				} else if (skeletonChild.getNodeName().equals("positionY")) {
					float positionY = Float.parseFloat(skeletonChild
							.getTextContent().replace(',', '.'));
					// System.out.println("positionY: " + positionY);
				} else if (skeletonChild.getNodeName().equals("positionZ")) {
					float positionZ = Float.parseFloat(skeletonChild
							.getTextContent().replace(',', '.'));
					// System.out.println("positionZ: " + positionZ);
				}

				if (this.gestureRecognition != null) {
					this.gestureRecognition.checkForGesture();
				}
			}
		}

	}

	private HumanBodyEnum getHumanPart(String jointId) {
		if (jointId.equals("Head")) {
			return HumanBodyEnum.Head;
		} else if (jointId.equals("HipCenter")) {
			return HumanBodyEnum.Hip_Center;
		} else if (jointId.equals("Spine")) {
			return HumanBodyEnum.Spine;
		} else if (jointId.equals("ShoulderCenter")) {
			return HumanBodyEnum.Shoulder_Center;
		} else if (jointId.equals("ShoulderLeft")) {
			return HumanBodyEnum.Shoulder_Left;
		} else if (jointId.equals("ElbowLeft")) {
			return HumanBodyEnum.Elbow_Left;
		} else if (jointId.equals("WristLeft")) {
			return HumanBodyEnum.Wrist_Left;
		} else if (jointId.equals("HandLeft")) {
			return HumanBodyEnum.Hand_Left;
		} else if (jointId.equals("ShoulderRight")) {
			return HumanBodyEnum.Shoulder_Right;
		} else if (jointId.equals("ElbowRight")) {
			return HumanBodyEnum.Elbow_Right;
		} else if (jointId.equals("WristRight")) {
			return HumanBodyEnum.Wrist_Right;
		} else if (jointId.equals("HandRight")) {
			return HumanBodyEnum.Hand_Right;
		} else if (jointId.equals("HipLeft")) {
			return HumanBodyEnum.Hip_Left;
		} else if (jointId.equals("KneeLeft")) {
			return HumanBodyEnum.Knee_Left;
		} else if (jointId.equals("AnkleLeft")) {
			return HumanBodyEnum.Ankle_Left;
		} else if (jointId.equals("FootLeft")) {
			return HumanBodyEnum.Foot_Left;
		} else if (jointId.equals("HipRight")) {
			return HumanBodyEnum.Hip_Right;
		} else if (jointId.equals("KneeRight")) {
			return HumanBodyEnum.Knee_Right;
		} else if (jointId.equals("AnkleRight")) {
			return HumanBodyEnum.Ankle_Right;
		} else if (jointId.equals("FootRight")) {
			return HumanBodyEnum.Foot_Right;
		}

		return null;

	}

	public void startGestureRecoginition() {
		if (this.gestureRecognition == null) {
			this.gestureRecognition = new GestureRecognition();
			this.gestureRecognition.setGestureListener(gestureListener);
		} else {
			//this.gestureRecognition = null;
			this.gestureRecognition.enableGestureRecognition();
		}
	}
	
	public void stopGestureRecognition() {
		if (this.gestureRecognition != null) {
			this.gestureRecognition.stopGestureRecognition();
		}
	}

	public void suspendGestureRecognition() {
		if (this.gestureRecognition != null)
			this.gestureRecognition.stopGestureRecognition();
		
	}
}
