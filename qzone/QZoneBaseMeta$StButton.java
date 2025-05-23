package qzone;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZoneBaseMeta$StButton extends MessageMicro<QZoneBaseMeta$StButton> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58}, new String[]{"text", AlbumCacheData.ACTIONURL, "button_img", "button_color", "button_color_after_click", "button_color2", "button_color_after_click2"}, new Object[]{"", "", "", "", "", "", ""}, QZoneBaseMeta$StButton.class);
    public final PBStringField text = PBField.initString("");
    public final PBStringField actionurl = PBField.initString("");
    public final PBStringField button_img = PBField.initString("");
    public final PBStringField button_color = PBField.initString("");
    public final PBStringField button_color_after_click = PBField.initString("");
    public final PBStringField button_color2 = PBField.initString("");
    public final PBStringField button_color_after_click2 = PBField.initString("");
}
