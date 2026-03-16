package ru.yanes.Tasks;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ShadowBan {
	public static void main(String[] args) {
		Comment comment1 = new Comment("Bob", "Lol", false);
		Comment comment2 = new Comment("Bob", "spam", true);
		Comment comment7 = new Comment("Bob", "Lol", false);
		Comment comment8 = new Comment("Bob", "spam", true);
		Comment comment6 = new Comment("Bob", "spam", true);
		Comment comment3 = new Comment("Tom", "Lol", false);
		Comment comment4 = new Comment("Blob", "spam", true);
		Comment comment5 = new Comment("Fill", "Lol", false);

		List<Comment> comments = Arrays.asList(comment1, comment2, comment6, comment3, comment4, comment5,  comment7,  comment8);

//		Collector<Comment, Map<String, Integer>, List<Comment>> collector = Collector.of(
//				HashMap::new,
//				(map, comment) -> {
//					if (map.containsKey(comment.user()) ) {
//						int count = map.get(comment.user());
//						map.put(comment.user(), count + 1);
//					}
//				},
//				(left, right) -> {},
//				result -> {
//
//				}
//		);

//		List<String> spammers = comments.parallelStream()
//				.collect(Collectors.collectingAndThen(
//							Collectors.groupingBy(Comment::user,
//								Collectors.collectingAndThen(Collectors.partitioningBy(Comment::isSpam, Collectors.counting()),
//									result -> result.get(true) > result.get(false) && result.get(true)+result.get(false) > 3)
//							),
//							map -> {
//								List<String> result = new ArrayList<>();
//								for (Map.Entry<String, Boolean> entry : map.entrySet()) {
//									if (entry.getValue()) {
//										result.add(entry.getKey());
//									}
//								}
//								return result;
//							})
//						);
		List<String> spammers = comments.parallelStream()
				.collect(Collectors.groupingBy(Comment::user,
								Collectors.partitioningBy(Comment::isSpam, Collectors.counting())
						))
				.entrySet().stream()
				.filter(entry ->{
					long spamCount = entry.getValue().get(true);
					long totalCount = entry.getValue().get(false) + spamCount;
					return totalCount > 3 && spamCount > totalCount/2;
				})
				.map(Map.Entry::getKey)
				.toList();
		System.out.println(spammers);
	}
}

record Comment(String user, String text, boolean isSpam) {}