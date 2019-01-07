package com.mellykusjes.chessmaxapi.interfaces;

import com.mellykusjes.chessmaxapi.models.Color;
import com.mellykusjes.chessmaxapi.models.Piece;

public interface PieceFactory {

    Piece createPiece(Color color, String type);
}
