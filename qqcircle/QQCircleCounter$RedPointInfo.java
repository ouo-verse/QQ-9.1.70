package qqcircle;

import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import com.tencent.xweb.FileReaderHelper;
import feedcloud.FeedCloudCommon$StCommonExt;

/* loaded from: classes29.dex */
public final class QQCircleCounter$RedPointInfo extends MessageMicro<QQCircleCounter$RedPointInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 40, 50, 56, 66, 72, 82, 90, 98, 170, 178, 186, 194, 202, 210, 218, 224, 234}, new String[]{"appid", "redType", "redTotalNum", "rptRedInfo", "pushTime", QFSEdgeItem.KEY_EXTEND, "lastVisitTime", "transInfo", "tabType", "redJumpInfo", "wording", "extInfo", "allPushInfo", "outLayerInfo", "qqProfileInfo", "groupInfo", "smallRedInfoExt", "pymkRedInfo", "squareRedExt", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TYPE, CacheTable.TABLE_NAME}, new Object[]{"", 0, 0, null, 0, "", 0L, ByteStringMicro.EMPTY, 1, null, "", null, null, null, null, null, null, null, null, 0, null}, QQCircleCounter$RedPointInfo.class);
    public final PBStringField appid = PBField.initString("");
    public final PBEnumField redType = PBField.initEnum(0);
    public final PBUInt32Field redTotalNum = PBField.initUInt32(0);
    public final PBRepeatMessageField<QQCircleCounterMsg$RedDisplayInfo> rptRedInfo = PBField.initRepeatMessage(QQCircleCounterMsg$RedDisplayInfo.class);
    public final PBUInt32Field pushTime = PBField.initUInt32(0);
    public final PBStringField extend = PBField.initString("");
    public final PBInt64Field lastVisitTime = PBField.initInt64(0);
    public final PBBytesField transInfo = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField tabType = PBField.initEnum(1);
    public QQCircleCounter$RedPointJumpInfo redJumpInfo = new QQCircleCounter$RedPointJumpInfo();
    public final PBStringField wording = PBField.initString("");
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public QQCircleCounter$AllPushPointInfo allPushInfo = new QQCircleCounter$AllPushPointInfo();
    public QQCircleCounter$OutLayerPointInfo outLayerInfo = new QQCircleCounter$OutLayerPointInfo();
    public QQCircleCounter$QQProfilePointInfo qqProfileInfo = new MessageMicro<QQCircleCounter$QQProfilePointInfo>() { // from class: qqcircle.QQCircleCounter$QQProfilePointInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{FileReaderHelper.TXT_EXT, "touin"}, new Object[]{"", ""}, QQCircleCounter$QQProfilePointInfo.class);
        public final PBStringField txt = PBField.initString("");
        public final PBStringField touin = PBField.initString("");
    };
    public QQCircleCounter$GroupPointInfo groupInfo = new QQCircleCounter$GroupPointInfo();
    public QQCircleCounter$SmallRedPointInfoExt smallRedInfoExt = new MessageMicro<QQCircleCounter$SmallRedPointInfoExt>() { // from class: qqcircle.QQCircleCounter$SmallRedPointInfoExt
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"unreadMsg", "wording"}, new Object[]{"", ""}, QQCircleCounter$SmallRedPointInfoExt.class);
        public final PBStringField unreadMsg = PBField.initString("");
        public final PBStringField wording = PBField.initString("");
    };
    public QQCircleCounter$PymkRedPointInfo pymkRedInfo = new MessageMicro<QQCircleCounter$PymkRedPointInfo>() { // from class: qqcircle.QQCircleCounter$PymkRedPointInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"wording"}, new Object[]{""}, QQCircleCounter$PymkRedPointInfo.class);
        public final PBStringField wording = PBField.initString("");
    };
    public QQCircleCounter$SquareRedExt squareRedExt = new QQCircleCounter$SquareRedExt();
    public final PBEnumField showType = PBField.initEnum(0);
    public QQCircleClientData$RedPointReportTransInfo reportInfo = new MessageMicro<QQCircleClientData$RedPointReportTransInfo>() { // from class: qqcircle.QQCircleClientData$RedPointReportTransInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 50, 58}, new String[]{"redType", "channelTransInfo", "sealTransInfo", "subRedType", "contentID", "recomMeta", "subRedTypes"}, new Object[]{0, "", "", 0, 0L, "", ""}, QQCircleClientData$RedPointReportTransInfo.class);
        public final PBInt32Field redType = PBField.initInt32(0);
        public final PBStringField channelTransInfo = PBField.initString("");
        public final PBStringField sealTransInfo = PBField.initString("");
        public final PBInt32Field subRedType = PBField.initInt32(0);
        public final PBInt64Field contentID = PBField.initInt64(0);
        public final PBStringField recomMeta = PBField.initString("");
        public final PBStringField subRedTypes = PBField.initString("");
    };
}
