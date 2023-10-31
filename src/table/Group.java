package table;

public class Group {
    private boolean rowGroupStatus = false;
    private boolean columnGroupStatus = false;
    private int topRowNumber;
    private int lowerRowNumber;
    private int leftColumnNumber;
    private int rightColumnNumber;
    public Group() {
        rowGroupStatus = false;
        columnGroupStatus = false;
    }

    public void setTopRowNumber(int topRowNumber) {
        this.topRowNumber = topRowNumber;
        rowGroupStatus = topRowNumber > 0;
    }

    public void setLowerRowNumber(int lowerRowNumber) {
        this.lowerRowNumber = lowerRowNumber;
        rowGroupStatus = lowerRowNumber > 0;
    }

    public void setLeftColumnNumber(int leftColumnNumber) {
        this.leftColumnNumber = leftColumnNumber;
        if (leftColumnNumber > 0) columnGroupStatus = true;
        else {
            columnGroupStatus = false;
        }
    }

    public void setRightColumnNumber(int rightColumnNumber) {
        this.rightColumnNumber = rightColumnNumber;
        columnGroupStatus = rightColumnNumber > 0;
    }

    public boolean isRowGroupStatus() {
        return rowGroupStatus;
    }

    public boolean isColumnGroupStatus() {
        return columnGroupStatus;
    }

    public int getTopRowNumber() {
        return topRowNumber;
    }

    public int getLowerRowNumber() {
        return lowerRowNumber;
    }

    public int getLeftColumnNumber() {
        return leftColumnNumber;
    }

    public int getRightColumnNumber() {
        return rightColumnNumber;
    }
//не очень нужно, потому что просто будем переприсваивать уже существующему объекту класса новый, а старый уберёт уборщик
//    public void offGroup(){
//        rowGroupStatus = false;
//        columnGroupStatus = false;
//        topRowNumber = 0;
//        lowerRowNumber = 0;
//        leftColumnNumber = 0;
//        rightColumnNumber = 0;
//    }
}
