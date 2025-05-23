package tencent.im.oidb.cmd0xc78;

import com.qzone.homepage.ui.Facade.model.FacadeCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xc78$AppMsgInfo extends MessageMicro<oidb_cmd0xc78$AppMsgInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"url", "title", "description", FacadeCacheData.THUMB_URL}, new Object[]{"", "", "", ""}, oidb_cmd0xc78$AppMsgInfo.class);
    public final PBStringField url = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField description = PBField.initString("");
    public final PBStringField thumb_url = PBField.initString("");
}
