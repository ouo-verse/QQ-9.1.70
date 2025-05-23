package tencent.im.oidb.ac;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ArticleComment$CreateArticleCommentRequest extends MessageMicro<ArticleComment$CreateArticleCommentRequest> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField article_id;
    public final PBBytesField comment;
    public final PBUInt32Field hide_name;
    public final PBUInt64Field uin;

    static {
        String[] strArr = {AppConstants.Key.SHARE_REQ_ARTICLE_ID, "uin", "comment", "hide_name"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32}, strArr, new Object[]{byteStringMicro, 0L, byteStringMicro, 0}, ArticleComment$CreateArticleCommentRequest.class);
    }

    public ArticleComment$CreateArticleCommentRequest() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.article_id = PBField.initBytes(byteStringMicro);
        this.uin = PBField.initUInt64(0L);
        this.comment = PBField.initBytes(byteStringMicro);
        this.hide_name = PBField.initUInt32(0);
    }
}
