/*
 * Copyright 2014 doug@neverfear.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.neverfear.util;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.neverfear.util.concurrent.Interrupts;

/**
 * @author doug@neverfear.org
 * 
 */
public class InterruptsTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void givenInterrupted_whenThrowIfInterrupted_expectInterruptedException() throws InterruptedException {
		// Given
		Thread.currentThread()
				.interrupt();

		// Then
		this.expectedException.expect(InterruptedException.class);

		// When
		Interrupts.throwIfInterrupted();
	}

	@Test
	public void givenUninterrupted_whenThrowIfInterrupted_expectNoException() throws InterruptedException {
		// Given
		// When
		Interrupts.throwIfInterrupted();

		// Success is measured by getting this far
	}
}
