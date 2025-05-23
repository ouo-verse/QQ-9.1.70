package qqcircle;

import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;

/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StKuoliePasterData extends MessageMicro<QQCircleFeedBase$StKuoliePasterData> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField kuolie_id = PBField.initString("");
    public final PBFloatField center_x = PBField.initFloat(0.0f);
    public final PBFloatField center_y = PBField.initFloat(0.0f);
    public final PBFloatField width = PBField.initFloat(0.0f);
    public final PBFloatField height = PBField.initFloat(0.0f);
    public final PBFloatField rotation = PBField.initFloat(0.0f);
    public final PBStringField scheme = PBField.initString("");
    public final PBStringField content = PBField.initString("");
    public final PBInt32Field click_type = PBField.initInt32(0);
    public final PBBytesField trans_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField highlight_words = PBField.initString("");

    static {
        String[] strArr = {"kuolie_id", "center_x", "center_y", "width", "height", BasicAnimation.KeyPath.ROTATION, ZPlanPublishSource.FROM_SCHEME, "content", "click_type", "trans_info", "highlight_words"};
        Float valueOf = Float.valueOf(0.0f);
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 21, 29, 37, 45, 53, 58, 66, 72, 82, 90}, strArr, new Object[]{"", valueOf, valueOf, valueOf, valueOf, valueOf, "", "", 0, ByteStringMicro.EMPTY, ""}, QQCircleFeedBase$StKuoliePasterData.class);
    }
}
