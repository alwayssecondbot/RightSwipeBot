package ru.yanes.IOstreams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class SerialVersionUIDCheck {
	public static void main(String[] args) throws FileNotFoundException {
		//if serialVersionUID in dat equals serialVersionUID in Car class, it's ok, otherwise ClassNotFoundException
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("myCar.dat"))) {
			Car oldCar = (Car) ois.readObject();
			System.out.println(oldCar);
		} catch (ClassNotFoundException | IOException e) {
			throw new RuntimeException(e);
		}
	}
}
