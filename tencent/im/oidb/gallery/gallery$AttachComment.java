package tencent.im.oidb.gallery;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class gallery$AttachComment extends MessageMicro<gallery$AttachComment> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"comment_info", "comment_icons"}, new Object[]{null, null}, gallery$AttachComment.class);
    public final PBRepeatMessageField<gallery$CommentIcon> comment_icons = PBField.initRepeatMessage(gallery$CommentIcon.class);
}
