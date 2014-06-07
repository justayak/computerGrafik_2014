/*
 * Copyright 2014 Christian Windolf christianwindolf@web.de.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package aufgabe41;

/**
 * @author Christian Windolf
 *
 */
public class Utils {


	/**
	 * 
	 * @param p
	 * @param q
	 * @return empty array, if no solution found, with length 1, 
	 * if only one could be found and an array with two elements, if the equation had two solutions
	 */
	public static double[] pq(double p, double q){
		double p2 = p/2d;
		double radicant = (p2 * p2) - q;
		if(radicant < 0){
			return new double[0];
		}
		if(radicant == 0){
			return new double[]{-p2};
		}
		
		return new double[]{p2 - Math.sqrt(radicant), p2 + Math.sqrt(radicant)};
	}

}
