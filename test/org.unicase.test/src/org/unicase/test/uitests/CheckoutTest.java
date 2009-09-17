package org.unicase.test.uitests;

import java.util.logging.FileHandler;
import java.util.logging.Logger;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.unicase.workspace.test.SetupHelper;

@SuppressWarnings( { "unused" })
@RunWith(SWTBotJunit4ClassRunner.class)
public class CheckoutTest {

	private static final String RESTRICTION = "restriction";
	private static SWTWorkbenchBot bot;

	@BeforeClass
	public static void beforeClass() throws Exception {
		bot = new SWTWorkbenchBot();
		bot.viewByTitle("Welcome").close();
		SetupHelper.startSever();

	}

	@Test
	public void checkoutProject() throws Exception {
		bot.menu("Window").menu("Show View").menu("Other...").click();
		SWTBotShell shell = bot.shell("Show View");
		shell.activate();
		bot.tree().expandNode("unicase").select("EmfStore Browser");
		bot.button("OK").click();
		SWTBotView viewById = bot.activeView();
		SWTBotTreeItem[] items = viewById.bot().tree().getAllItems();
		items[0].getText();
		Logger logger = Logger.getLogger("LoggerTest");
		logger.addHandler(new FileHandler("log.txt"));

		int countofelem = (items[0].expand().rowCount());
		if (countofelem == 0) {
			logger.info("the project list is empty");
			items[0].select().contextMenu("Create new project...").click();
			bot.textWithLabel("Name:").typeText("testproject");
			bot.button("OK").click();
			items[0].expand();
		} else {
			logger.info("the project list is not empty");
			SWTBotTreeItem[] subitem = items[0].getItems();
			subitem[0].select().contextMenu("Checkout").click();
		}

	}

	@AfterClass
	public static void sleep() {
		bot.sleep(5000);
		SetupHelper.stopServer();
	}
}
