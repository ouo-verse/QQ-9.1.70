package qqcircle;

import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleSmartMatchMusic$SmartMatchMusicReq extends MessageMicro<QQCircleSmartMatchMusic$SmartMatchMusicReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBBytesField videoBuffer = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field videoDuration = PBField.initUInt32(0);
    public final PBUInt32Field dataType = PBField.initUInt32(0);
    public final PBRepeatField<ByteStringMicro> vecPicBuffer = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBDoubleField fLat = PBField.initDouble(0.0d);
    public final PBDoubleField fLon = PBField.initDouble(0.0d);
    public final PBUInt32Field videoType = PBField.initUInt32(0);
    public final PBUInt32Field cameraType = PBField.initUInt32(0);
    public final PBDoubleField videoLat = PBField.initDouble(0.0d);
    public final PBDoubleField videoLon = PBField.initDouble(0.0d);
    public final PBUInt64Field videoTime = PBField.initUInt64(0);
    public final PBStringField wording = PBField.initString("");
    public final PBRepeatField<String> vecPicUrl = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBUInt32Field scene = PBField.initUInt32(0);
    public final PBBoolField requireLyrics = PBField.initBool(false);

    static {
        String[] strArr = {"extInfo", "videoBuffer", "videoDuration", "dataType", "vecPicBuffer", "fLat", "fLon", "videoType", ShortVideoConstants.PARAM_KEY_CAMERA_TYPE, "videoLat", "videoLon", QFSEdgeItem.KEY_VIDEO_TIME, "wording", "vecPicUrl", "scene", "requireLyrics"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        Double valueOf = Double.valueOf(0.0d);
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 49, 57, 64, 72, 81, 89, 96, 106, 114, 120, 128}, strArr, new Object[]{null, byteStringMicro, 0, 0, byteStringMicro, valueOf, valueOf, 0, 0, valueOf, valueOf, 0L, "", "", 0, Boolean.FALSE}, QQCircleSmartMatchMusic$SmartMatchMusicReq.class);
    }
}
