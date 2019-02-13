package com.ds.design.algorithm.week3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestMain {

	public static void main(String[] args) {
		List<Point> points = new ArrayList<>();
		Point point = new Point(2,true);
		points.add(point);
		point = new Point(1,false);
		points.add(point);
		Collections.sort(points, new PointComparator());
		points.forEach(p->System.out.println(p.interval));
	}
	private static class Point{
		private int interval;
		private boolean isStart;
		public Point(int interval, boolean isStart) {
			super();
			this.interval = interval;
			this.isStart = isStart;
		}
		
	}

	private static class PointComparator implements Comparator<Point> {

		@Override
		public int compare(Point o1, Point o2) {
			if (o1.interval == o2.interval) {
				return 0;
			} else if (o1.interval > o2.interval) {
				return 1;
			} else {
				return -1;
			}
		}

	}
}
