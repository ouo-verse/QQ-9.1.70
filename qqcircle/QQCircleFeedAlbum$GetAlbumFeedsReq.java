package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import cooperation.qqcircle.report.QCircleLpReportDc05502;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedAlbum$GetAlbumFeedsReq extends MessageMicro<QQCircleFeedAlbum$GetAlbumFeedsReq> {
    public static final int PAGE_DOWN = 0;
    public static final int PAGE_UP = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 48}, new String[]{QCircleScheme.AttrQQPublish.PICKER_ALBUM_ID, "attach_info", "skip", "count", "load_more_type", QCircleLpReportDc05502.KEY_BEGIN_TIME}, new Object[]{0L, "", 0L, 0, 0, 0L}, QQCircleFeedAlbum$GetAlbumFeedsReq.class);
    public final PBUInt64Field album_id = PBField.initUInt64(0);
    public final PBStringField attach_info = PBField.initString("");
    public final PBInt64Field skip = PBField.initInt64(0);
    public final PBInt32Field count = PBField.initInt32(0);
    public final PBEnumField load_more_type = PBField.initEnum(0);
    public final PBUInt64Field begin_time = PBField.initUInt64(0);
}
