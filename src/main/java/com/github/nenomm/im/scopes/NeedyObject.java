package com.github.nenomm.im.scopes;

public class NeedyObject {
	TransientCollaborator collaborator;

	public TransientCollaborator getCollaborator() {
		return collaborator;
	}

	public void setCollaborator(TransientCollaborator collaborator) {
		this.collaborator = collaborator;
	}
}
