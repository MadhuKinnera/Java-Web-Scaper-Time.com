package com.dtl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProcessHTML {

	public List<Story> getSixStories(String pageData) {

		String word = "headline heading-content-tiny margin-8-bottom media-heading";

		List<Integer> list = getAllIndices(pageData, word);

		System.out.println("indices are " + list);

		List<String> aTags = getAllAnchorTags(pageData, list);

		System.out.println("the a tags are " + aTags);

		List<Story> stories = getSixStories(aTags);

		return stories;

	}

	private List<Integer> getAllIndices(String pageData, String word) {

		List<Integer> list = new ArrayList<>();

		Pattern pattern = Pattern.compile(word);

		Matcher matcher = pattern.matcher(pageData);

		while (matcher.find()) {
			int index = matcher.start() + 2;
			list.add(index + word.length());
		}

		return list;
	}

	private List<String> getAllAnchorTags(String pageData, List<Integer> indices) {

		List<String> aTags = new ArrayList<>();

		for (Integer i : indices) {

			int temp = i;

			String tString = "";

			while (!tString.equals("a>")) {
				tString = pageData.charAt(temp) + "" + pageData.charAt(temp + 1);
				temp++;
			}

			String tag = pageData.substring(i, temp + 1);

			aTags.add(tag);

		}

		return aTags;

	}

	private List<Story> getSixStories(List<String> aTags) {

		List<Story> stories = new ArrayList<>();

		for (int k = 0; k < 6; k++) {

			String tag = aTags.get(k);

			int startInd = -1;
			int endInd = -1;

			for (int i = 0; i < tag.length(); i++) {

				if (Character.compare('\"', tag.charAt(i)) == 0) {

					if (startInd == -1) {
						startInd = i;
					} else if (endInd == -1) {
						endInd = i;
					}
				}

				if (startInd != -1 && endInd != -1) {
					break;
				}
			}

			String link = tag.substring(startInd, endInd + 1);

			System.out.println("link is " + link);

			startInd = endInd + 2;

			endInd = tag.length() - 5;

			String title = tag.substring(startInd, endInd + 1);

			System.out.println("the title is " + title);

			Story story = new Story();

			story.setLink(link);
			story.setTitle(title);

			stories.add(story);
		}

		return stories;

	}

}
