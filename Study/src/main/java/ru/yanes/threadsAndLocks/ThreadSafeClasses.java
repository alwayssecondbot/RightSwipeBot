package ru.yanes.threadsAndLocks;

import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadSafeClasses {
	public static void main(String[] args){
		Hashtable<String,Integer> hashtable = new Hashtable<>();
		ConcurrentHashMap<String,Integer> concurrentHashMap = new ConcurrentHashMap<>();
	}
}
