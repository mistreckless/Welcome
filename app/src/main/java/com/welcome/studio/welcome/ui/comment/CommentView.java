package com.welcome.studio.welcome.ui.comment;

import com.welcome.studio.welcome.model.data.CommentModel;

import java.util.List;

/**
 * Created by @mistreckless on 28.02.2017. !
 */
interface CommentView {

    void addComments(List<CommentModel> comments);

    void addComment(CommentModel comment);

    void refreshComments(int position);

    void refreshComment(int position);

    void refresh();

    void updateCommentView(CommentModel comment, int position);

    void setSendView(boolean enabled);

    void updateCommentEvent(CommentModel comment);

    void hideKeyboard();
}