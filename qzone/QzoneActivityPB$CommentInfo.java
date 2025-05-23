package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceProxy;

/* loaded from: classes29.dex */
public final class QzoneActivityPB$CommentInfo extends MessageMicro<QzoneActivityPB$CommentInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"comment_id", IPreloadServiceProxy.KEY_RESINFO}, new Object[]{"", null}, QzoneActivityPB$CommentInfo.class);
    public final PBStringField comment_id = PBField.initString("");
    public QzoneActivityPB$ResourceInfo res_info = new QzoneActivityPB$ResourceInfo();
}
