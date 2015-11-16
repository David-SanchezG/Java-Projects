public class SuitPile extends CardPile {

	SuitPile (int x, int y) { super(x, y); }

	public boolean canTake (Card aCard) {
		if (isEmpty())
			return aCard.rank() == 0;
		Card topCard = top();
		return (aCard.suit() == topCard.suit()) &&
			(aCard.rank() == 1 + topCard.rank());
		}
}