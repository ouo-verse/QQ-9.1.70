package qzonemoment;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZMomentMeta$StReply extends MessageMicro<QZMomentMeta$StReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 50, 56, 66, 72, 80, 90, 98}, new String[]{"id", "postUser", WadlProxyConsts.CREATE_TIME, "content", "targetUser", "likeInfo", "modifyflag", "atUinList", "typeFlag", "createTimeNs", "storeExtInfo", MessageForQCircleFeed.MSG_QCIRCLE_FEED_LEY_BUSI_DATA}, new Object[]{"", null, 0L, "", null, null, 0, "", 0, 0L, null, ByteStringMicro.EMPTY}, QZMomentMeta$StReply.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f430366id = PBField.initString("");
    public QZMomentMeta$StUser postUser = new QZMomentMeta$StUser();
    public final PBUInt64Field createTime = PBField.initUInt64(0);
    public final PBStringField content = PBField.initString("");
    public QZMomentMeta$StUser targetUser = new QZMomentMeta$StUser();
    public QZMomentMeta$StLike likeInfo = new QZMomentMeta$StLike();
    public final PBUInt32Field modifyflag = PBField.initUInt32(0);
    public final PBRepeatField<String> atUinList = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBUInt32Field typeFlag = PBField.initUInt32(0);
    public final PBUInt64Field createTimeNs = PBField.initUInt64(0);
    public final PBRepeatMessageField<QZMomentCommon$Entry> storeExtInfo = PBField.initRepeatMessage(QZMomentCommon$Entry.class);
    public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
}
