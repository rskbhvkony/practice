package com.edu;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

public class SingletonTest {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private static final String className = "com.edu.MyMySingleton";

	public static void main(String[] args) throws Exception {

		System.out.println("*** Serialization-Safe MySingleton ***");
		serializationSafeMySingletonTest();

	}

	private static void serializationSafeMySingletonTest() {
		MySingleton object1 = MySingleton.getInstance();
		MySingleton object2 = MySingleton.getInstance();

		if (object1 == object2)
			System.out.println("Serialization-Safe MySingleton - Both objects are same");
		else
			System.out.println("Serialization-Safe MySingleton - Both objects are different");

		System.out.print("Serialization and De-Serialization of Serialization-Safe MySingleton: ");
		try {
			checkSerializationAndDeserialization(object1);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		System.out.print("Reflection API Attack: ");
		System.out.println("  -1- > ");
		Constructor[] constructors = MySingleton.class.getDeclaredConstructors();
		System.out.println("  -2- > ");
		Constructor constructor = constructors[0];
		System.out.println("  -3- > ");
		constructor.setAccessible(true);
		System.out.println("  -4- > ");
		try {
			MySingleton s1 = (MySingleton) constructor.newInstance();
			MySingleton s2 = (MySingleton) constructor.newInstance();
			System.out.println("  -- > " + s1);
			System.out.println("  -- > " + s2);
			if (s1 != s2)
				System.out.println("Private Constructor is now exposed. MySingleton behaviour is collapsed\n");
			else
				System.out.println("Private Constructor is not exposed. MySingleton behaviour preserved\n");
		} catch (Exception e) {
			System.out.println("  -5- > ");
			System.out.println("  -6- > " + e.getMessage());
		}
	}

	private static void checkSerializationAndDeserialization(MySingleton singleton) throws Exception {
		// Serializing singleton to SerializedObject.obj
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(
				new FileOutputStream("src/com/edu/SerializedObject.obj"));

		objectOutputStream.writeObject(singleton);

		objectOutputStream.close();

		// De-Serializing singleton from SerializationSafeSingleton.obj
		ObjectInputStream objectInputStream = new ObjectInputStream(
				new FileInputStream("src/com/edu/SerializedObject.obj"));

		MySingleton deserializedObject = (MySingleton) objectInputStream.readObject();

		objectInputStream.close();

		// Verification
		if (deserializedObject.hashCode() != singleton.hashCode())
			System.out.println("Serialized and Deserialized objects are two different copies after deserializing");
		else
			System.out.println("Serialized and Deserialized objects are same copies after deserializing");

		System.out.println("Object HashCode before serializing: " + singleton.hashCode());
		System.out.println("Object HashCode after de-serializing: " + deserializedObject.hashCode());
	}

	/*
	 * 
	 * private static void lazyMySingletonTest() {
	 * System.out.print("Trying to load the class and see if instance is created: "
	 * ); try { // Attempt to load the class Class.forName(className +
	 * "MySingleton"); System.out.println("Class '" + className + "MySingleton" +
	 * "' is loaded."); } catch (ClassNotFoundException e) {
	 * System.out.println("Class '" + className + "MySingleton" +
	 * "' is not loaded."); }
	 * 
	 * System.out.print("Creating Lazy MySingleton Objects: "); MySingleton object1
	 * = MySingleton.getInstance(); MySingleton object2 = MySingleton.getInstance();
	 * 
	 * if (object1 == object2)
	 * System.out.println("Lazy MySingleton - Both objects are same\n"); else
	 * System.out.println("Lazy MySingleton - Both objects are different\n");
	 * 
	 * }
	 * 
	 * private static void eagerMySingletonTest() {
	 * System.out.print("Trying to load the class and see if instance is created: "
	 * ); try { // Attempt to load the class Class.forName(className +
	 * "EagerMySingleton"); System.out.println("Class '" + className +
	 * "EagerMySingleton" + "' is loaded."); } catch (ClassNotFoundException e) {
	 * System.out.println("Class '" + className + "EagerMySingleton" +
	 * "' is not loaded."); }
	 * 
	 * EagerMySingleton object1 = EagerMySingleton.getInstance(); EagerMySingleton
	 * object2 = EagerMySingleton.getInstance();
	 * 
	 * if (object1 == object2)
	 * System.out.println("Eager MySingleton - Both objects are same\n"); else
	 * System.out.println("Eager MySingleton - Both objects are different\n"); }
	 * 
	 * private static void threadSafeMySingletonTest() { ThreadSafeMySingleton
	 * object1 = ThreadSafeMySingleton.getInstance(); ThreadSafeMySingleton object2
	 * = ThreadSafeMySingleton.getInstance();
	 * 
	 * if (object1 == object2)
	 * System.out.println("Thread-Safe MySingleton - Both objects are same"); else
	 * System.out.println("Thread-Safe MySingleton - Both objects are different");
	 * 
	 * // Test for thread safety - Uncomment the below line and check for
	 * "Thread Entry Count". If each thread has count = 1, then it's Thread safe //
	 * MyThread.execute(); }
	 * 
	 * 
	 * private static void enumMySingletonTest() {
	 * System.out.print("Trying to load the class and see if instance is created: "
	 * ); try { // Attempt to load the class Class.forName(className +
	 * "EnumMySingleton"); System.out.println("Class '" + className +
	 * "EnumMySingleton" + "' is loaded."); } catch (ClassNotFoundException e) {
	 * System.out.println("Class '" + className + "EnumMySingleton" +
	 * "' is not loaded."); }
	 * 
	 * EnumMySingleton object1 = EnumMySingleton.ENUM_MySingleton_INSTANCE;
	 * EnumMySingleton object2 = EnumMySingleton.ENUM_MySingleton_INSTANCE;
	 * 
	 * if (object1 == object2)
	 * System.out.println("Enum MySingleton - Both objects are same"); else
	 * System.out.println("Enum MySingleton - Both objects are different");
	 * 
	 * 
	 * System.out.print("Serialization and De-Serialization of Enum MySingleton: ");
	 * try { checkSerializationAndDeserialization(object1); } catch (Exception e) {
	 * System.out.println("Exception: " + e.getMessage()); }
	 * 
	 * System.out.print("Reflection API Attack: "); Constructor[] constructors =
	 * EnumMySingleton.class.getDeclaredConstructors(); Constructor constructor =
	 * constructors[0]; constructor.setAccessible(true);
	 * 
	 * try { EnumMySingleton s1 = (EnumMySingleton) constructor.newInstance();
	 * EnumMySingleton s2 = (EnumMySingleton) constructor.newInstance(); } catch
	 * (Exception e) { System.out.println(e.getMessage()); }
	 * 
	 * EnumMySingleton.ENUM_MySingleton_INSTANCE.display(); }
	 * 
	 * private static void
	 * checkSerializationAndDeserialization(SerializationSafeMySingleton
	 * MySingleton) throws Exception { // Serializing MySingleton to
	 * SerializedObject.obj ObjectOutputStream objectOutputStream = new
	 * ObjectOutputStream(new FileOutputStream(
	 * "src/com/neelesh/design/patterns/creational/MySingleton/serialized_objects/SerializedObject.obj"
	 * ));
	 * 
	 * objectOutputStream.writeObject(MySingleton);
	 * 
	 * objectOutputStream.close();
	 * 
	 * // De-Serializing MySingleton from SerializationSafeMySingleton.obj
	 * ObjectInputStream objectInputStream = new ObjectInputStream(new
	 * FileInputStream(
	 * "src/com/neelesh/design/patterns/creational/MySingleton/serialized_objects/SerializedObject.obj"
	 * ));
	 * 
	 * SerializationSafeMySingleton deserializedObject =
	 * (SerializationSafeMySingleton) objectInputStream.readObject();
	 * 
	 * objectInputStream.close();
	 * 
	 * // Verification if (deserializedObject.hashCode() != MySingleton.hashCode())
	 * System.out.
	 * println("Serialized and Deserialized objects are two different copies after deserializing"
	 * ); else System.out.
	 * println("Serialized and Deserialized objects are same copies after deserializing"
	 * );
	 * 
	 * System.out.println("Object HashCode before serializing: " +
	 * MySingleton.hashCode());
	 * System.out.println("Object HashCode after de-serializing: " +
	 * deserializedObject.hashCode()); }
	 * 
	 * private static void checkSerializationAndDeserialization(EnumMySingleton
	 * MySingleton) throws Exception { // Serializing MySingleton to
	 * SerializedObject.obj ObjectOutputStream objectOutputStream = new
	 * ObjectOutputStream(new FileOutputStream(
	 * "src/com/neelesh/design/patterns/creational/MySingleton/serialized_objects/SerializedObject.obj"
	 * ));
	 * 
	 * objectOutputStream.writeObject(MySingleton);
	 * 
	 * objectOutputStream.close();
	 * 
	 * // De-Serializing MySingleton from SerializedObject.obj ObjectInputStream
	 * objectInputStream = new ObjectInputStream(new FileInputStream(
	 * "src/com/neelesh/design/patterns/creational/MySingleton/serialized_objects/SerializedObject.obj"
	 * ));
	 * 
	 * EnumMySingleton deserializedObject = (EnumMySingleton)
	 * objectInputStream.readObject();
	 * 
	 * objectInputStream.close();
	 * 
	 * // Verification if (deserializedObject.hashCode() != MySingleton.hashCode())
	 * System.out.
	 * println("Serialized and Deserialized objects are two different copies after deserializing"
	 * ); else System.out.
	 * println("Serialized and Deserialized objects are same copies after deserializing"
	 * );
	 * 
	 * System.out.println("Object HashCode before serializing: " +
	 * MySingleton.hashCode());
	 * System.out.println("Object HashCode after de-serializing: " +
	 * deserializedObject.hashCode()); }
	 */
}