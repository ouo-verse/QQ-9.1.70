package tencent.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.jsp.AskAnonymouslyApiPlugin;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TroopMultiGroupManageSvr$InviteMethod extends MessageMicro<TroopMultiGroupManageSvr$InviteMethod> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"allow_invite", AskAnonymouslyApiPlugin.KEY_INVITE_TYPE}, new Object[]{0, 0}, TroopMultiGroupManageSvr$InviteMethod.class);
    public final PBUInt32Field allow_invite = PBField.initUInt32(0);
    public final PBUInt32Field invite_type = PBField.initUInt32(0);
}
