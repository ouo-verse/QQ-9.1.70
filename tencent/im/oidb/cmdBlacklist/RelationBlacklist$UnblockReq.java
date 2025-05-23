package tencent.im.oidb.cmdBlacklist;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class RelationBlacklist$UnblockReq extends MessageMicro<RelationBlacklist$UnblockReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"account"}, new Object[]{null}, RelationBlacklist$UnblockReq.class);
    public RelationBlacklist$Account account = new RelationBlacklist$Account();
}
