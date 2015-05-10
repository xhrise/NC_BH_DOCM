package nc.ui.mmgp.uif2.actions.grand;

import nc.ui.pubapp.uif2app.actions.BodyInsertLineAction;
import nc.ui.pubapp.uif2app.event.card.BodyRowEditType;
import nc.ui.pubapp.uif2app.event.card.CardBodyAfterRowEditEvent;

/**
 * <b> ��Ҫ�������� </b>
 * <p>
 * �������������в���
 * </p>
 * 
 * @since �������� Sep 18, 2013
 * @author wangweir
 */
public class MMGPGrandBodyInsertLineAction extends BodyInsertLineAction {

    /*
     * (non-Javadoc)
     * @see nc.ui.pubapp.uif2app.actions.BodyInsertLineAction#doAction()
     */
    @Override
    public void doAction() {
        // int row = this.getCardPanel().getBillTable().getSelectedRow();
        // this.getCardPanel().getBillTable().getSelectionModel().setSelectionInterval(row, row);
        // super.doAction();
        int row = this.getCardPanel().getBillTable().getSelectedRow();
        boolean doOperateFlag = false;
        if (row >= 0 && row < this.getCardPanel().getBillModel().getRowCount()) {
            this.getCardPanel().getBillModel().insertRow(row);
            doOperateFlag = true;
        }
        if (doOperateFlag) {
            this.getCardPanel().getBillModel().setValueAt(null, row, "precolumn");
            this.getCardPanel().getBodyPanel().getTable().getSelectionModel().setSelectionInterval(row + 1, row + 1);
            this.onDataInsert();
            this.fireEvent();
        }

    }

    protected void fireEvent() {
        int[] rows = new int[]{this.getCardPanel().getBodyPanel().getTable().getSelectedRow() };
        this.getModel().fireEvent(
            new CardBodyAfterRowEditEvent(this.getCardPanel(), BodyRowEditType.INSERTLINE, rows));
    }
}
