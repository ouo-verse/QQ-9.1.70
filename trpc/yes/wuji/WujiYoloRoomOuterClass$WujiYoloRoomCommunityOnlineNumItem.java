package trpc.yes.wuji;

import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class WujiYoloRoomOuterClass$WujiYoloRoomCommunityOnlineNumItem extends MessageMicro<WujiYoloRoomOuterClass$WujiYoloRoomCommunityOnlineNumItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42}, new String[]{Element.ELEMENT_NAME_MIN, "max", "text", "icon", "text_color"}, new Object[]{0, 0, "", "", ""}, WujiYoloRoomOuterClass$WujiYoloRoomCommunityOnlineNumItem.class);
    public final PBInt32Field min = PBField.initInt32(0);
    public final PBInt32Field max = PBField.initInt32(0);
    public final PBStringField text = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBStringField text_color = PBField.initString("");
}
