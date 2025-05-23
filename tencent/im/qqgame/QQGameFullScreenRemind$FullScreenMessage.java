package tencent.im.qqgame;

import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameFullScreenRemind$FullScreenMessage extends MessageMicro<QQGameFullScreenRemind$FullScreenMessage> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 56, 64}, new String[]{"title", "content", "head", QZoneAdTianshuFeedData.KEY_BUTTON_TEXT, "button_link", "show_platform", "filter", "show_seconds"}, new Object[]{"", "", "", "", "", 0, 0, 0}, QQGameFullScreenRemind$FullScreenMessage.class);
    public final PBStringField title = PBField.initString("");
    public final PBStringField content = PBField.initString("");
    public final PBStringField head = PBField.initString("");
    public final PBStringField button_text = PBField.initString("");
    public final PBStringField button_link = PBField.initString("");
    public final PBEnumField show_platform = PBField.initEnum(0);
    public final PBEnumField filter = PBField.initEnum(0);
    public final PBUInt32Field show_seconds = PBField.initUInt32(0);
}
