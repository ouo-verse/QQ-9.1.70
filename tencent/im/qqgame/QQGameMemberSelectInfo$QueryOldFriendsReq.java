package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameMemberSelectInfo$QueryOldFriendsReq extends MessageMicro<QQGameMemberSelectInfo$QueryOldFriendsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"groupCode"}, new Object[]{0L}, QQGameMemberSelectInfo$QueryOldFriendsReq.class);
    public final PBUInt64Field groupCode = PBField.initUInt64(0);
}
