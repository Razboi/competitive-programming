# https://www.codewars.com/kata/5672a98bdbdd995fad00000f
# Let's play! You have to return which player won! In case of a draw return Draw!.

defmodule RockPaperScissors do
	def rps(p1, p2) do
		cond do
			nemesis(p1) == p2 -> "Player 2 won!"
			nemesis(p2) == p1 -> "Player 1 won!"
			true -> "Draw!"
		end
	end

	defp nemesis("scissors"), do: "rock"
	defp nemesis("rock"), do: "paper"
	defp nemesis("paper"), do: "scissors"
end