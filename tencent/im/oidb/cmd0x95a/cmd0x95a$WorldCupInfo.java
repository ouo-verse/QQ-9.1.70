package tencent.im.oidb.cmd0x95a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x95a$WorldCupInfo extends MessageMicro<cmd0x95a$WorldCupInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"str_share_id", "str_nick", "str_video_url", "str_config", "str_qq_head_url"}, new Object[]{"", "", "", "", ""}, cmd0x95a$WorldCupInfo.class);
    public final PBStringField str_share_id = PBField.initString("");
    public final PBStringField str_nick = PBField.initString("");
    public final PBStringField str_video_url = PBField.initString("");
    public final PBStringField str_config = PBField.initString("");
    public final PBStringField str_qq_head_url = PBField.initString("");
}
