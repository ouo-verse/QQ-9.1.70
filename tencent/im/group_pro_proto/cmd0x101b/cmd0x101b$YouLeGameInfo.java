package tencent.im.group_pro_proto.cmd0x101b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x101b$YouLeGameInfo extends MessageMicro<cmd0x101b$YouLeGameInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"game_param", "mode_id"}, new Object[]{null, 0}, cmd0x101b$YouLeGameInfo.class);
    public cmd0x101b$GameParam game_param = new cmd0x101b$GameParam();
    public final PBInt32Field mode_id = PBField.initInt32(0);
}
