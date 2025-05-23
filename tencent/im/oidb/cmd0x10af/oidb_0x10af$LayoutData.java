package tencent.im.oidb.cmd0x10af;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x10af$LayoutData extends MessageMicro<oidb_0x10af$LayoutData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"action_data", "render_data"}, new Object[]{"", null}, oidb_0x10af$LayoutData.class);
    public final PBStringField action_data = PBField.initString("");
    public oidb_0x10af$RenderData render_data = new MessageMicro<oidb_0x10af$RenderData>() { // from class: tencent.im.oidb.cmd0x10af.oidb_0x10af$RenderData
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"cover", "title", "tips"}, new Object[]{"", "", ""}, oidb_0x10af$RenderData.class);
        public final PBStringField cover = PBField.initString("");
        public final PBStringField title = PBField.initString("");
        public final PBStringField tips = PBField.initString("");
    };
}
