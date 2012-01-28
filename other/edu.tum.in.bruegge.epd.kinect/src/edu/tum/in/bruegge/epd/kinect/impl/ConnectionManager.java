package edu.tum.in.bruegge.epd.kinect.impl;

import java.io.IOException;

public interface ConnectionManager {

	void openConnection() throws IOException;
	void closeConnection() throws IOException;

	void startSkeletonTracking();
	void stopSkeletonTracking();
	
	void startSpeechRecognition(String[] keywords);
	void stopSpeechRecognition();
	
	void setDataHandler(KinectDataHandler dataHandler);
}
