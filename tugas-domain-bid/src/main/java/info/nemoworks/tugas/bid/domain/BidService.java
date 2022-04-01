package info.nemoworks.tugas.bid.domain;

import info.nemoworks.tugas.bid.boundary.command.ApproveCommand;
import info.nemoworks.tugas.bid.boundary.command.CreateCommand;
import info.nemoworks.tugas.bid.boundary.query.ApprovingQuery;
import info.nemoworks.tugas.bid.boundary.query.CreatingQuery;
import info.nemoworks.tugas.bid.boundary.query.EditingQuery;


public interface BidService {

    public void handleCreateCommand(CreateCommand command);

    public void handleApproveCommand(ApproveCommand command);

//    public void handleCloseCommand(CloseCommand command);

//    public void handleEditContentCommand(EditContentCommand command);

//    public void handleAppendAddonCommand(AppendAddonCommand command);

    public CreatingQuery queryOnCreating(Bid bid);

    public EditingQuery queryOnEditing(Bid bid);

    public ApprovingQuery queryOnApproving(Bid bid);

    public void bootstrap();
}
