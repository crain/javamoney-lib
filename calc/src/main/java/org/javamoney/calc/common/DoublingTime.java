/*
 *  Copyright (c) 2012, 2013, Credit Suisse (Anatole Tresch), Werner Keil.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.javamoney.calc.common;

import java.math.BigDecimal;

import org.javamoney.calc.Calculation;



/**
 * The Doubling Time formula is used in Finance to calculate the length of time
 * required to double an investment or money in an interest bearing account. It
 * is important to note that r in the doubling time formula is the rate per
 * period. If one wishes to calculate the amount of time to double their money
 * in a money market account that is compounded monthly, then r needs to express
 * the monthly rate and not the annual rate. The monthly rate can be found by
 * dividing the annual rate by 12. With this situation, the doubling time
 * formula will give the number of months that it takes to double money and not
 * years. In addition to expressing r as the monthly rate if the account is
 * compounded monthly, one could also use the effective annual rate, or annual
 * percentage yield, as r in the doubling time formula.
 * 
 * @see http://www.financeformulas.net/Doubling_Time.html
 * @author Anatole Tresch
 * @author Werner Keil
 */
public class DoublingTime implements Calculation<Rate, BigDecimal> {

	/**
	 * This function returns the number of periods required to double an amount
	 * with continuous compounding, given a rate.
	 */
	@Override
	public BigDecimal calculate(Rate rate) {
		return BigDecimal.valueOf(Math.log(2.0d)).divide(
				BigDecimal.valueOf(Math.log(1.0d)).add(rate.get()));
	}

}
