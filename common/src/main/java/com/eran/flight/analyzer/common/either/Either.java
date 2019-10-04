
package com.eran.flight.analyzer.common.either;

public class Either<Failure, Success> {

    private Failure left = null;

    private Success right = null;

    private Either(Failure a, Success b) {
        left = a;
        right = b;
    }

    public static <Failure, Success> Either<Failure, Success> left(Failure a) {
        return new Either<>(a, null);
    }

    public static <Failure, Success> Either<Failure, Success> right(Success b) {
        return new Either<>(null, b);
    }

    public Failure left() {
        return left;
    }

    public boolean isLeft() {
        return left != null;
    }

    public boolean isRight() {
        return right != null;
    }

    public Success right() {
        return right;
    }
}
