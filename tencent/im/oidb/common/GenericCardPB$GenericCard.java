package tencent.im.oidb.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;

/* loaded from: classes29.dex */
public final class GenericCardPB$GenericCard extends MessageMicro<GenericCardPB$GenericCard> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 50, 58}, new String[]{"icon_url", "title", IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_BACKGROUND_URL, "jump_url", "style", "items", "intro"}, new Object[]{"", "", "", "", 0, null, ""}, GenericCardPB$GenericCard.class);
    public final PBStringField icon_url = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField background_url = PBField.initString("");
    public final PBStringField jump_url = PBField.initString("");
    public final PBUInt32Field style = PBField.initUInt32(0);
    public final PBRepeatMessageField<GenericCardPB$GenericCardItem> items = PBField.initRepeatMessage(GenericCardPB$GenericCardItem.class);
    public final PBStringField intro = PBField.initString("");
}
