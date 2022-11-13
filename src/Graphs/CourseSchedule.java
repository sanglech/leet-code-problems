package Graphs;

import java.util.*;

public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        if (numCourses ==0) return true;

        HashMap<Integer, List<Integer>> courses = new HashMap<>();
        for( int i =0; i<numCourses;i++){
            courses.put(i,new ArrayList<>());
        }

        for (int[] prereq: prerequisites){
            int src = prereq[0], dest = prereq[1];
            if(!courses.containsKey(src) || !courses.containsKey(dest)){
                return false;
            }
            courses.get(src).add(dest);
        }

        for (int i: courses.keySet()){
            if(isCyclic(i,courses,new HashSet<Integer>())){
                return false;
            }
        }
        return true;
    }

    public static boolean isCyclic(int currentCourse, HashMap<Integer,List<Integer>> courses, HashSet<Integer> visited){
        if(visited.contains(currentCourse)) return true;
        if(courses.get(currentCourse).isEmpty()) return false;
        visited.add(currentCourse);

        List<Integer> thing = courses.get(currentCourse);
        for(Integer i: thing){
            if(isCyclic(i,courses,visited)){
                return true;
            };
        }

        visited.remove(currentCourse);
        courses.put(currentCourse, Collections.emptyList());
        return false;
    }

}
