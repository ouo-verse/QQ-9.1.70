package tencent.im.oidb.cmd0x10af;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x10af$Reply extends MessageMicro<oidb_0x10af$Reply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"keyword", TtmlNode.TAG_LAYOUT}, new Object[]{"", null}, oidb_0x10af$Reply.class);
    public final PBStringField keyword = PBField.initString("");
    public final PBRepeatMessageField<oidb_0x10af$Layout> layout = PBField.initRepeatMessage(oidb_0x10af$Layout.class);
}
