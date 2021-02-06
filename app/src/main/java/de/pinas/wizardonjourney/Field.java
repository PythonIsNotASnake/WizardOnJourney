package de.pinas.wizardonjourney;

import android.view.View;
import android.widget.Button;

public class Field {

    private boolean hasCharacter;
    private int positionColumn;
    private int positionRow;
    private Button button;

    public Field(int positionColumn, int positionRow, Button button, boolean hasCharacter) {
        this.positionColumn = positionColumn;
        this.positionRow = positionRow;
        this.button = button;
        this.hasCharacter = hasCharacter;
        GoAction goAction = new GoAction();
        button.setOnClickListener(goAction);
    }

    public boolean isHasCharacter() {
        return hasCharacter;
    }

    public void setHasCharacter(boolean hasCharacter) {
        this.hasCharacter = hasCharacter;
    }

    public int getPositionColumn() {
        return positionColumn;
    }

    public void setPositionColumn(int positionColumn) {
        this.positionColumn = positionColumn;
    }

    public int getPositionRow() {
        return positionRow;
    }

    public void setPositionRow(int positionRow) {
        this.positionRow = positionRow;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    class GoAction implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            if ((getPositionRow() - 1 == Globals.getInstance().getRowCharacter()
                    && (getPositionColumn() >= Globals.getInstance().getColumnCharacter() - 1 && getPositionColumn() <= Globals.getInstance().getColumnCharacter() + 1))
                    ||
                    (getPositionRow() + 1 == Globals.getInstance().getRowCharacter()
                            && (getPositionColumn() >= Globals.getInstance().getColumnCharacter() - 1 && getPositionColumn() <= Globals.getInstance().getColumnCharacter() + 1))
                    ||
                    (getPositionColumn() - 1 == Globals.getInstance().getColumnCharacter()
                            && (getPositionRow() >= Globals.getInstance().getRowCharacter() - 1 && getPositionRow() <= Globals.getInstance().getRowCharacter() + 1))
                    ||
                    (getPositionColumn() + 1 == Globals.getInstance().getColumnCharacter()
                            && (getPositionRow() >= Globals.getInstance().getRowCharacter() - 1 && getPositionRow() <= Globals.getInstance().getRowCharacter() + 1))
            ) {
                //view.setBackgroundResource(0);
                //view.setBackgroundColor(Color.TRANSPARENT);
                //view.setBackgroundResource(R.mipmap.charactermap);
                getButton().setBackgroundResource(R.mipmap.charactermap);
                Globals.getInstance().getMap()[Globals.getInstance().getColumnCharacter()][Globals.getInstance().getRowCharacter()].getButton().setBackgroundResource(R.mipmap.terrain);
                //Globals.getInstance().getMap()[getPositionColumn()][getPositionRow()].getButton().setBackgroundColor(Color.TRANSPARENT);
                //Globals.getInstance().getMap()[getPositionColumn()][getPositionRow()].getButton().setBackgroundColor(Color.parseColor("#fafafa"));
                Globals.getInstance().setColumnCharacter(getPositionColumn());
                Globals.getInstance().setRowCharacter(getPositionRow());
            }


        }
    }

}
