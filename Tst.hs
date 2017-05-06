import Data.Char
twoDigits2Int a b | isDigit a && isDigit b = a*10+b
--twoDigits2Int a b | !(isDigit a || isDigit b) = 100
