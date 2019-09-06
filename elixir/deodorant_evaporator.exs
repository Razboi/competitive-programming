# https://www.codewars.com/kata/deodorant-evaporator/train/elixir

# This program tests the life of an evaporator containing a gas.
# We know the content of the evaporator (content in ml), the percentage of foam or gas lost every day
# (evap_per_day) and the threshold (threshold) in percentage beyond which the evaporator is no longer useful.
# All numbers are strictly positive.

# The program reports the nth day (as an integer) on which the evaporator will be out of use.

defmodule Evaporator do

	@spec evaporator(number, number, number) :: number
	def evaporator(content, evap_per_day, threshold) do
		calculate_remaining_usage(0, 100, evap_per_day/100, threshold)
	end

	@spec calculate_remaining_usage(number, number, number, number) :: number
	defp calculate_remaining_usage(day, current_gas, evap_per_day, threshold) do
		if current_gas < threshold do
			day
		else
			new_current_gas = current_gas - current_gas * evap_per_day
			calculate_remaining_usage(day + 1, new_current_gas, evap_per_day, threshold)
		end
	end
end
