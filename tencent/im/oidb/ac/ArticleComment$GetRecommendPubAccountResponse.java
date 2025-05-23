package tencent.im.oidb.ac;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class ArticleComment$GetRecommendPubAccountResponse extends MessageMicro<ArticleComment$GetRecommendPubAccountResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"ret", "recom_list", "recom_title"}, new Object[]{null, null, ByteStringMicro.EMPTY}, ArticleComment$GetRecommendPubAccountResponse.class);
    public ArticleComment$RetInfo ret = new ArticleComment$RetInfo();
    public final PBRepeatMessageField<ArticleComment$Record> recom_list = PBField.initRepeatMessage(ArticleComment$Record.class);
    public final PBBytesField recom_title = PBField.initBytes(ByteStringMicro.EMPTY);
}
