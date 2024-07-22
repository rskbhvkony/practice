package com.com.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTest {
	public static void main(String[] args) {
		CompletableFuture<String> firstTask = CompletableFuture.supplyAsync(() -> {
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) { // TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return "First Task";
		});
		CompletableFuture<String> secondTask = CompletableFuture.supplyAsync(() -> "Task 2");
		CompletableFuture<Void> combinedTask = CompletableFuture.allOf(firstTask, secondTask);

		firstTask.thenAccept(result -> System.out.println(result + " completed."));
		secondTask.thenAccept(result -> System.out.println(result + " completed."));
		combinedTask.thenRun(() -> System.out.println("All tasks completed."));

		/*
		 * ExecutorService executorService = Executors.newFixedThreadPool(2);
		 * Future<String> future1 = executorService.submit(() -> { for(int i =0;
		 * i<50;i++) { try { Thread.sleep(1000); } catch (InterruptedException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); } } return "First Task";
		 * }); Future<String> future2 = executorService.submit(() ->
		 * "ExecutorService Task 2"); executorService.shutdown();
		 * 
		 * try { System.out.println(future1.get() + "ExecutorService Task1 completed.");
		 * System.out.println(future2.get() + " completed."); } catch
		 * (InterruptedException | ExecutionException e) { e.printStackTrace(); }
		 */
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello CompletableFuture");

		try {
			System.out.println(future.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
}
