package tencent.im.oidb.ac;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ArticleComment$LikeRet extends MessageMicro<ArticleComment$LikeRet> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uin", "like"}, new Object[]{0L, 0}, ArticleComment$LikeRet.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt32Field like = PBField.initUInt32(0);
}
