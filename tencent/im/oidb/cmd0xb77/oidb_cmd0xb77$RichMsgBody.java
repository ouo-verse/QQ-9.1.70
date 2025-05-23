package tencent.im.oidb.cmd0xb77;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xb77$RichMsgBody extends MessageMicro<oidb_cmd0xb77$RichMsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 82, 90, 98, 106, 114, 122, 130, 170}, new String[]{"using_ark", "title", "summary", "brief", "url", "picture_url", "action", "music_url", "image_info"}, new Object[]{Boolean.FALSE, "", "", "", "", "", "", "", null}, oidb_cmd0xb77$RichMsgBody.class);
    public final PBBoolField using_ark = PBField.initBool(false);
    public final PBStringField title = PBField.initString("");
    public final PBStringField summary = PBField.initString("");
    public final PBStringField brief = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBStringField picture_url = PBField.initString("");
    public final PBStringField action = PBField.initString("");
    public final PBStringField music_url = PBField.initString("");
    public oidb_cmd0xb77$ImageInfo image_info = new oidb_cmd0xb77$ImageInfo();
}
