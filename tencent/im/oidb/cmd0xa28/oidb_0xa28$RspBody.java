package tencent.im.oidb.cmd0xa28;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xa28$RspBody extends MessageMicro<oidb_0xa28$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_profile_info", "msg_game_info"}, new Object[]{null, null}, oidb_0xa28$RspBody.class);
    public oidb_0xa28$Profile msg_profile_info = new oidb_0xa28$Profile();
    public oidb_0xa28$HonourInfo msg_game_info = new oidb_0xa28$HonourInfo();
}
