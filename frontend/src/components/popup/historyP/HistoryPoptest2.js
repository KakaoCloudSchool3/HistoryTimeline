import React, { useState, useEffect } from 'react';
import axios from 'axios';
import HistoryCom from './HistoryPoPComponent/HistoryCom';
import MovieCom from './HistoryPoPComponent/MovieCom';
import "./HistoryPop.css";

const HistoryPoptest2 = () => {
    const [historyData, setHistoryData] = useState(null);
    const [moviesData, setMoviesData] = useState([]);
    const historyId = 11;

    useEffect(() => {
        const fetchData = async () => {
            try {
                // 백엔드에서 히스토리 데이터 가져오기
                const historyResponse = await axios.get(`http://localhost:8081/historyPop/${historyId}`);
                const transformedHistoryData = { ...historyResponse.data, content: historyResponse.data.brief };
                transformedHistoryData.detail = historyResponse.data.detail;
                setHistoryData(transformedHistoryData);

                // 백엔드에서 영화 데이터 가져오기
                const moviesResponse = await axios.get('http://localhost:8081/movies');
                setMoviesData(moviesResponse.data);
            } catch (error) {
                console.error('Error fetching data:', error);
            }
        };

        fetchData();
    }, [historyId]);

    return (
        <div className="HistoryPop">
            <div className="history-container">                
                {historyData && (
                    <HistoryCom 
                        imgUrl={historyData.imgUrl} 
                        title={historyData.title} 
                        content={[historyData.content]} 
                        detail={historyData.detail} 
                    />
                )}
            </div>
            <div className="movie-container">
                <MovieCom movies={moviesData}  />
            </div>
        </div>
    );
};

export default HistoryPoptest2;
