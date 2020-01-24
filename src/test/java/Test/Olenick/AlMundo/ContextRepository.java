package Test.Olenick.AlMundo;

public class ContextRepository {
	public static TestContext get() {
		return new ThreadLocal<TestContext>().get();
	}
	public static void set(TestContext context) {
		new ThreadLocal<TestContext>().set(context);
	}
}
