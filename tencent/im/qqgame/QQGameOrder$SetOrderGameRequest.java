package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameOrder$SetOrderGameRequest extends MessageMicro<QQGameOrder$SetOrderGameRequest> {
    public static final int OPERATION_ADD_KING_CARD_AUTH = 6;
    public static final int OPERATION_ADD_ORDER = 0;
    public static final int OPERATION_ADD_ORDER_KING_CARD_AUTH = 8;
    public static final int OPERATION_AUTO_DOWNLOAD_COMPLETE = 2;
    public static final int OPERATION_CANCEL_KING_CARD_AUTH = 7;
    public static final int OPERATION_CANCEL_ORDER = 1;
    public static final int OPERATION_CANCEL_ORDER_KING_CARD_AUTH = 9;
    public static final int OPERATION_MANUAL_DOWNLOAD_COMPLETE = 5;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{QCircleDaTongConstant.ElementParamValue.OPERATION, "channel_id", "app_ids"}, new Object[]{0, "", ""}, QQGameOrder$SetOrderGameRequest.class);
    public final PBEnumField operation = PBField.initEnum(0);
    public final PBStringField channel_id = PBField.initString("");
    public final PBRepeatField<String> app_ids = PBField.initRepeat(PBStringField.__repeatHelper__);
}
