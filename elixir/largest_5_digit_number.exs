# https://www.codewars.com/kata/51675d17e0c1bed195000001
# Complete the solution so that it returns the greatest sequence of five consecutive digits found within the number given. The number will be passed in as a string of only digits. It should return a five digit integer. The number passed may be as large as 1000 digits.

defmodule LargestInSeries do
  @spec solution(String.t) :: integer
  def solution(digits) do
    digits
    |> String.to_integer()
    |> Integer.digits()
    |> Stream.chunk_every(5, 1)
    |> Enum.max()
    |> Integer.undigits()
  end
end
    