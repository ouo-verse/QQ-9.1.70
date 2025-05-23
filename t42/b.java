package t42;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.icgame.data.room.LiveInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveRoomConfigInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveStreamIdInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveTrtcInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveVideoStatus;
import com.tencent.mobileqq.qqlive.data.room.LiveWatchMediaInfo;
import com.tencent.mobileqq.qqlive.data.room.RoomTag;
import com.tencent.mobileqq.qqlive.data.room.realtime.LiveRealTimeInfo;
import com.tencent.mobileqq.qqlive.data.room.realtime.MetricsType;
import com.tencent.mobileqq.qqlive.data.room.realtime.RealTimeData;
import com.tencent.mobileqq.qqlive.data.room.stream.ServiceAddressInfo;
import com.tencent.mobileqq.qqlive.data.room.stream.ServiceFrameInfo;
import com.tencent.mobileqq.qqlive.data.room.stream.ServiceStreamInfo;
import com.tencent.qphone.base.util.QLog;
import yy0.k;
import yy0.m;
import yy0.p;
import yy0.q;
import yy0.r;
import yy0.s;
import yy0.t;
import yy0.u;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {
    @NonNull
    private static LiveRoomConfigInfo a(yy0.d dVar) {
        LiveRoomConfigInfo liveRoomConfigInfo = new LiveRoomConfigInfo();
        if (dVar != null) {
            liveRoomConfigInfo.commonConfig = dVar.f451434b;
            liveRoomConfigInfo.currentRoomConfig = dVar.f451433a;
            liveRoomConfigInfo.gameRoomConfig = dVar.f451435c;
            liveRoomConfigInfo.normalRoomConfig = dVar.f451436d;
        }
        return liveRoomConfigInfo;
    }

    public static LiveInfo b(yy0.f fVar) {
        m[] mVarArr;
        LiveInfo liveInfo = new LiveInfo();
        liveInfo.userFlag = fVar.f451447f;
        liveInfo.anchorType = fVar.f451455n;
        LiveRoomInfo liveRoomInfo = new LiveRoomInfo();
        p pVar = fVar.f451445d;
        if (pVar != null) {
            liveRoomInfo.roomId = pVar.f451510a;
            liveRoomInfo.ownerId = pVar.f451511b;
            liveRoomInfo.roomName = pVar.f451513d;
            liveRoomInfo.roomLogo = pVar.f451512c;
            liveRoomInfo.programId = pVar.f451518i;
            liveRoomInfo.giftFlag = pVar.f451516g;
            liveRoomInfo.goodsFlag = pVar.f451517h;
            liveRoomInfo.roomType = pVar.f451514e;
            liveRoomInfo.enterRoomSystemNotice = pVar.f451519j;
            q qVar = pVar.f451515f;
            if (qVar != null && (mVarArr = qVar.f451520a) != null) {
                for (m mVar : mVarArr) {
                    RoomTag roomTag = new RoomTag();
                    roomTag.type = mVar.f451505a;
                    roomTag.text = mVar.f451506b;
                    roomTag.url = mVar.f451507c;
                    liveRoomInfo.tags.add(roomTag);
                }
            }
        } else {
            QLog.e("ICGameLiveInfoProvider", 1, "parseLiveAudienceLiveInfo roomInfo is null");
        }
        liveInfo.setRoomInfo(liveRoomInfo);
        LiveAnchorInfo liveAnchorInfo = new LiveAnchorInfo();
        u uVar = fVar.f451446e;
        if (uVar != null) {
            liveAnchorInfo.uid = uVar.f451534a;
            liveAnchorInfo.nickName = uVar.f451536c;
            liveAnchorInfo.explicitId = uVar.f451537d;
            liveAnchorInfo.headUrl = uVar.f451538e;
            liveAnchorInfo.businessUid = uVar.f451541h;
            liveAnchorInfo.initialClientType = uVar.f451540g;
            liveAnchorInfo.imsdkTinyId = uVar.f451539f;
            liveAnchorInfo.wechatPub = uVar.f451542i;
            liveAnchorInfo.sex = uVar.f451535b;
        }
        liveInfo.setAnchorInfo(liveAnchorInfo);
        LiveWatchMediaInfo liveWatchMediaInfo = new LiveWatchMediaInfo();
        if (fVar.f451448g != null) {
            LiveVideoStatus[] values = LiveVideoStatus.values();
            yy0.a aVar = fVar.f451448g;
            liveWatchMediaInfo.mVideoStatus = values[aVar.f451406a];
            liveWatchMediaInfo.mRtmpUrl = "";
            liveWatchMediaInfo.mRtmpUrlHigh = "";
            liveWatchMediaInfo.mRtmpUrlLow = "";
            liveWatchMediaInfo.mRtmpUrlLowest = "";
            k kVar = aVar.f451411f;
            if (kVar != null) {
                liveWatchMediaInfo.mRtmpUrl = kVar.f451485a;
                liveWatchMediaInfo.mRtmpUrlHigh = kVar.f451486b;
                liveWatchMediaInfo.mRtmpUrlLow = kVar.f451487c;
                liveWatchMediaInfo.mRtmpUrlLowest = kVar.f451488d;
            }
            k kVar2 = aVar.f451412g;
            if (kVar2 != null) {
                liveWatchMediaInfo.mHLSUrl = kVar2.f451485a;
            }
            k kVar3 = aVar.f451413h;
            if (kVar3 != null) {
                liveWatchMediaInfo.mFlvUrl = kVar3.f451485a;
                liveWatchMediaInfo.mFlvUrlHigh = kVar3.f451486b;
                liveWatchMediaInfo.mFlvUrlLow = kVar3.f451487c;
                liveWatchMediaInfo.mFlvUrlLowest = kVar3.f451488d;
            }
            liveWatchMediaInfo.sig = aVar.f451408c;
            liveWatchMediaInfo.sigTimeOut = aVar.f451409d;
            liveWatchMediaInfo.mSdkType = aVar.f451407b;
            yy0.e eVar = aVar.f451414i;
            if (eVar != null) {
                d(eVar, liveWatchMediaInfo);
                if (fVar.f451448g.f451414i.f451438b == 1) {
                    liveWatchMediaInfo.forceSwitch = true;
                }
            }
        }
        liveInfo.watchMediaInfo = liveWatchMediaInfo;
        liveInfo.configInfo = a(fVar.f451451j);
        if (fVar.f451453l != null) {
            LiveTrtcInfo liveTrtcInfo = new LiveTrtcInfo();
            liveInfo.trtcInfo = liveTrtcInfo;
            t tVar = fVar.f451453l;
            liveTrtcInfo.sig = tVar.f451532a;
            liveTrtcInfo.time = tVar.f451533b;
        }
        if (fVar.f451454m != null) {
            LiveStreamIdInfo liveStreamIdInfo = new LiveStreamIdInfo();
            liveInfo.streamIdInfo = liveStreamIdInfo;
            s sVar = fVar.f451454m;
            liveStreamIdInfo.uid = sVar.f451525a;
            liveStreamIdInfo.roomId = sVar.f451526b;
            liveStreamIdInfo.mainStreamId = sVar.f451527c;
            liveStreamIdInfo.auxStreamId = sVar.f451528d;
            liveStreamIdInfo.isSelfInfo = sVar.f451529e;
            liveStreamIdInfo.originUid = sVar.f451530f;
            liveStreamIdInfo.originRoomId = sVar.f451531g;
        }
        liveInfo.streamType = fVar.f451457p;
        liveInfo.nowTimeMs = fVar.f451458q;
        liveInfo.setGameID(fVar.f451460s);
        return liveInfo;
    }

    public static LiveRealTimeInfo c(ny0.c cVar) {
        LiveRealTimeInfo liveRealTimeInfo = new LiveRealTimeInfo();
        ny0.d dVar = cVar.f421574a;
        if (dVar == null) {
            return liveRealTimeInfo;
        }
        liveRealTimeInfo.roomId = dVar.f421577c;
        liveRealTimeInfo.programId = dVar.f421575a;
        liveRealTimeInfo.anchorId = dVar.f421576b;
        ny0.a[] aVarArr = dVar.f421578d;
        if (aVarArr != null && aVarArr.length != 0) {
            for (ny0.a aVar : aVarArr) {
                RealTimeData realTimeData = new RealTimeData();
                realTimeData.isShow = aVar.f421571d;
                int i3 = aVar.f421568a;
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                                realTimeData.type = MetricsType.DEFAULT;
                            } else {
                                realTimeData.type = MetricsType.NUM_OF_LIKE;
                            }
                        } else {
                            realTimeData.type = MetricsType.CUR_UV;
                        }
                    } else {
                        realTimeData.type = MetricsType.CUMULATIVE_UV;
                    }
                } else {
                    realTimeData.type = MetricsType.TOTAL_LIVE_TIME;
                }
                realTimeData.name = aVar.f421569b;
                realTimeData.value = aVar.f421570c;
                liveRealTimeInfo.items.add(realTimeData);
            }
        }
        return liveRealTimeInfo;
    }

    private static void d(yy0.e eVar, LiveWatchMediaInfo liveWatchMediaInfo) {
        r rVar;
        liveWatchMediaInfo.sugLevel = eVar.f451440d;
        r[] rVarArr = eVar.f451437a;
        if (rVarArr != null && rVarArr.length > 0 && (rVar = rVarArr[0]) != null) {
            ServiceStreamInfo serviceStreamInfo = new ServiceStreamInfo();
            serviceStreamInfo.name = rVar.f451523b;
            int i3 = rVar.f451524c;
            serviceStreamInfo.rawLevel = i3;
            liveWatchMediaInfo.mLevel = i3;
            yy0.h[] hVarArr = rVar.f451522a;
            if (hVarArr != null) {
                for (yy0.h hVar : hVarArr) {
                    ServiceFrameInfo serviceFrameInfo = new ServiceFrameInfo();
                    serviceFrameInfo.level = hVar.f451472a;
                    serviceFrameInfo.definition = hVar.f451474c;
                    yy0.b[] bVarArr = hVar.f451473b;
                    if (bVarArr != null) {
                        for (yy0.b bVar : bVarArr) {
                            ServiceAddressInfo serviceAddressInfo = new ServiceAddressInfo();
                            serviceAddressInfo.bitrate = bVar.f451423b;
                            serviceAddressInfo.url = bVar.f451422a;
                            serviceFrameInfo.addresses.add(serviceAddressInfo);
                        }
                    }
                    if (serviceFrameInfo.level == liveWatchMediaInfo.sugLevel) {
                        liveWatchMediaInfo.sugServiceFrameInfo = serviceFrameInfo;
                    }
                    serviceStreamInfo.frames.add(serviceFrameInfo);
                }
            }
            liveWatchMediaInfo.serviceStreamInfo = serviceStreamInfo;
        }
        ServiceFrameInfo serviceFrameInfo2 = liveWatchMediaInfo.sugServiceFrameInfo;
        if (serviceFrameInfo2 != null && serviceFrameInfo2.addresses.size() > 0) {
            liveWatchMediaInfo.mUrl = liveWatchMediaInfo.sugServiceFrameInfo.addresses.get(0).url;
            liveWatchMediaInfo.mUrlHigh = liveWatchMediaInfo.sugServiceFrameInfo.addresses.get(0).url;
            liveWatchMediaInfo.mUrlLow = liveWatchMediaInfo.sugServiceFrameInfo.addresses.get(0).url;
            liveWatchMediaInfo.mUrlLowest = liveWatchMediaInfo.sugServiceFrameInfo.addresses.get(0).url;
        }
    }
}
